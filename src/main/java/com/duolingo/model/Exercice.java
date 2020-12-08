package com.duolingo.model;

import javax.persistence.*;

@Entity
@Table(name = "Exercice")
public class Exercice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private short id;
    
    @ManyToOne()
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "STATUS")
    private int status;
    
    @Column(name = "TYPE_EXCERCICE")
    private int typeExercice;
    
    @Column(name = "WORD1")
    private String word1;
    
    @Column(name = "WORD2")
    private String word2;
    
    @Column(name = "WORD3")
    private String word3;
    
    @Column(name = "WORD4")
    private String word4;
    
    @Column(name = "WORD5")
    private String word5;
    
    @Column(name = "WORD6")
    private String word6;


    // -----CONSTRUCTORES-----
    public Exercice() {
    }

    public Exercice(String name, int status, int typeExercice, String word1, String word2, String word3, String word4, String word5, String word6) {

        this.name = name;
        this.status = status;
        this.typeExercice = typeExercice;
        this.word1 = word1;
        this.word2 = word2;
        this.word3 = word3;
        this.word1 = word4;
        this.word2 = word5;
        this.word3 = word6;

    }
    
    public Exercice(String name, int status, int typeExercice, String word1, String word2, String word3, String word4) {
    	this.name = name;
    	this.status = status;
    	this.typeExercice = typeExercice;
    	this.word1 = word1;
    	this.word2 = word2;
    	this.word3 = word3;
    	this.word4 = word4;
    	
    }

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTypeExercice() {
		return typeExercice;
	}

	public void setTypeExercice(int typeExercice) {
		this.typeExercice = typeExercice;
	}

	public String getWord1() {
		return word1;
	}

	public void setWord1(String word1) {
		this.word1 = word1;
	}

	public String getWord2() {
		return word2;
	}

	public void setWord2(String word2) {
		this.word2 = word2;
	}

	public String getWord3() {
		return word3;
	}

	public void setWord3(String word3) {
		this.word3 = word3;
	}

	public String getWord4() {
		return word4;
	}

	public void setWord4(String word4) {
		this.word4 = word4;
	}

	public String getWord5() {
		return word5;
	}

	public void setWord5(String word5) {
		this.word5 = word5;
	}

	public String getWord6() {
		return word6;
	}

	public void setWord6(String word6) {
		this.word6 = word6;
	}
	
	
}
