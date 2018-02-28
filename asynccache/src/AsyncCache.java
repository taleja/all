import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class AsyncCache<K, V> {

	private Map<K, Entry<V>> map = new ConcurrentHashMap<>();
	private long expiration;

	AsyncCache(long expiration) {
		this.expiration = expiration;
	}

	CompletableFuture<V> getOrCompute(K key, Function<K, CompletableFuture<V>> supplier) {
		if (map.containsKey(key)) {
			Entry<V> value = map.get(key);
			long currentTime = System.currentTimeMillis();
			if (value.getExpirationTime() > currentTime) {
				return value.getValue();
			} else {
				map.remove(key);
			}
		}
		CompletableFuture<V> future = supplier.apply(key);
		future.handle((value, error) -> {
			if(error != null) 
				map.remove(key);
			return value;
		});
		map.put(key, new Entry<V>(future, System.currentTimeMillis() + expiration));
		return future;

	}

	boolean containsKey(K key) {
		return map.containsKey(key);
	}

	private static class Entry<V> {
		private CompletableFuture<V> value;
		private long expirationTime;

		public Entry(CompletableFuture<V> value, long expirationTime) {
			this.value = value;
			System.out.println("==========");
			this.expirationTime = expirationTime;
		}

		public CompletableFuture<V> getValue() {
			return value;
		}

		public void setValue(CompletableFuture<V> value) {
			this.value = value;
		}

		public long getExpirationTime() {
			return expirationTime;
		}

		public void setExpirationTime(long expirationTime) {
			this.expirationTime = expirationTime;
		}

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		AsyncCache<String, String> cache = new AsyncCache<>(3000);
//		System.out.println(cache.getOrCompute("Olena", AsyncCache::valueSupplier).get());
//		System.out.println(cache.getOrCompute("Olena", AsyncCache::valueSupplier).get());
//		Thread.sleep(2000); 
		////System.out.println(cache.getOrCompute("Olena", AsyncCache::valueSupplier).get());
		cache.getOrCompute("Denis", AsyncCache::valueSupplier);
		Thread.sleep(10000); 
		//System.out.println(cache.getOrCompute("Denis", AsyncCache::valueSupplier).get());
	}

	private static CompletableFuture<String> valueSupplier(String str) {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			try {
				if(str.equals("Denis")) {
					throw new RuntimeException();	
				}
				Thread.sleep(2000);
				System.out.println("value created");
			} catch (InterruptedException e) {

			}
			return str + "Hello";
		});
		return completableFuture;
	}

}
