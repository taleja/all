package springBootProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(value = MockitoJUnitRunner.class)
public class ArticleServiceTest {
	
	@Mock
	private IArticleDAO articleDAO;
	@InjectMocks
	private ArticleService articleService;
	
	@Test 
	public void getArticleById() {
		//given
		int id = 3;
		Article expectedArticle = new Article();
		expectedArticle.setArticleId(id);
		Mockito.when(articleDAO.getArticleById(Mockito.eq(id))).thenReturn(expectedArticle);
		
		//when
		Article article = articleService.getArticleById(id);
		
		//then
		assertEquals(id, article.getArticleId()); 
	}

	@Test 
	public void getArticleById_NotFound() {
		//given
		int id = 3;
		Article expectedArticle = new Article();
		expectedArticle.setArticleId(id);
		Mockito.when(articleDAO.getArticleById(Mockito.eq(id))).thenThrow(new EntityNotFoundException());
		
		//when
		Article article = articleService.getArticleById(id);
		
		//then
		assertNull(article); 
	}
}
