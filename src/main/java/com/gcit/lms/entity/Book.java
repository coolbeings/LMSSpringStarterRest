package com.gcit.lms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="tbl_book", catalog="library")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="title", scope=Book.class)
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bookId;
	
	@NotNull
	@Length(max=45)
	private String title;

	@ManyToMany
	@JoinTable(name = "tbl_book_authors", joinColumns = { @JoinColumn(name = "bookId") }, inverseJoinColumns = { @JoinColumn(name = "authorId") })
	private List<Author> authors;
	
	@ManyToOne
	@JoinColumn(name="pubId")
	private Publisher publishers;

	@ManyToMany
	@JoinTable(name = "tbl_book_genres", joinColumns = { @JoinColumn(name = "bookId") }, inverseJoinColumns = { @JoinColumn(name = "genre_id") })
	private List<Genre> genres;
	
	@ManyToMany
	@JoinTable(name = "tbl_book_copies", joinColumns = { @JoinColumn(name = "bookId") }, inverseJoinColumns = { @JoinColumn(name = "branchId") })
	private List<Branch> branches;
	

	/**
	 * @return the branches
	 */
	public List<Branch> getBranches() {
		return branches;
	}
	/**
	 * @param branches the branches to set
	 */
	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the authors
	 */
	public List<Author> getAuthors() {
		return authors;
	}
	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	/**
	 * @return the publisher
	 */
	public Publisher getPublisher() {
		return publishers;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Publisher publisher) {
		this.publishers = publisher;
	}
	/**
	 * @return the genres
	 */
	public List<Genre> getGenres() {
		return genres;
	}
	/**
	 * @param genres the genres to set
	 */
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
}
