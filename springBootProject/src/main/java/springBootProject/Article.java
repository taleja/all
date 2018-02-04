package springBootProject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="articles")
public class Article  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="article_id")
	private int article_id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="category")
	private String category;
	
	/**
	 * @return the articleId
	 */
	public int getArticleId() {
		return article_id;
	}

	public void setArticleId(int articleId) {
		this.article_id = articleId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
}
