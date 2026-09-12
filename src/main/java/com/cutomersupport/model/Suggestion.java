package com.cutomersupport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name="Suggestions")
public class Suggestion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SuggestionId")
	private long SuggestionId;
	
	@Column(name="SuggestorName")
	private String Name;
	
	@Column(name="SuggestorEmailId")
	private String EmailId;
	
	@Column(name="Suggestion", columnDefinition="TEXT")
	private String Suggestion;
	
	@Column(name="SuggestedAt")
	private LocalDateTime SuggestedAt;
	
	public long getSuggestionId() {
		return SuggestionId;
	}
	public String getSuggestorName() {
		return Name;
	}
	public String getSuggestorEmailId() {
		return EmailId;
	}
	public String getSuggestion() {
		return Suggestion;
	}
	public LocalDateTime getSuggestedAt() {
		return SuggestedAt;
	}
	public void setSuggestionID(long SuggestionId) {
		this.SuggestionId=SuggestionId;
	}
	public void setSuggestorName(String Name) {
		this.Name=Name;
	}
	public void setSuggestion(String Suggestion) {
		this.Suggestion=Suggestion;
	}
	public void setSuggestorEmailId(String EmailId) {
		this.EmailId=EmailId;
	}
	public void setSuggestedAt(LocalDateTime SuggestedAt) {
		this.SuggestedAt=SuggestedAt;
	}
}
