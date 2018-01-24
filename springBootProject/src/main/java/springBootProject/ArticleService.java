package springBootProject;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author olena.viliuzhanina
 *
 */
@Service
public class ArticleService implements IArticleService{

	@Autowired
	private IArticleDAO articleDAO;
	
	public List<Article> getAllArticles() {
		return articleDAO.getAllArticles();
	}

	public Article getArticleById(int articleId) {
		Article obj =  articleDAO.getArticleById(articleId);
		return obj;
	}

	public boolean addArticle(Article article) {
		if(articleDAO.articleExists(article.getTitle(), article.getCategory())) {
			return false;
		} else {
			articleDAO.addArticle(article);
			return true;
		}
	}

	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}

	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}

}
