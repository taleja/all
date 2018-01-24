package springBootProject;

import java.util.List;

/**
 * @author olena.viliuzhanina
 *
 */
public interface IArticleDAO {
	
	List<Article> getAllArticles();
	Article getArticleById(int articleId);
	void addArticle(Article article);
	void updateArticle(Article article);
	void deleteArticle(int articleIde);
	boolean articleExists(String title, String category);

}
