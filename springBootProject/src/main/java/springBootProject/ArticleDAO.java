package springBootProject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author olena.viliuzhanina
 *
 */
@Transactional
@Repository
public class ArticleDAO implements IArticleDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Article> getAllArticles() {
		String hql = "From Article as atcl Order by atcl.article_id";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}

	public Article getArticleById(int articleId) {
		return entityManager.find(Article.class, articleId); 
	}

	public void addArticle(Article article) {
		entityManager.persist(article);
	}

	public void updateArticle(Article article) {
		Article artcl =  getArticleById(article.getArticleId());
		artcl.setTitle(article.getTitle());
		artcl.setCategory(article.getCategory());
		entityManager.flush();
	}

	public void deleteArticle(int articleId) {
		entityManager.remove(getArticleById(articleId));
	}

	public boolean articleExists(String title, String category) {
		String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title).setParameter(2, category).getResultList().size();
		
		return count > 0 ? true : false;
	}

}
