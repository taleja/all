package springBootProject;

import java.util.List;

/**
 * @author olena.viliuzhanina
 *
 */
public interface IArticleService {
	List<Article> getAllArticles();

	Article getArticleById(int articleId);

	boolean addArticle(Article article);

	void updateArticle(Article article);

	void deleteArticle(int articleId);
}
