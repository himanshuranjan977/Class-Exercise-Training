package com.gl.hiber;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "citizen")
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	 @Column(name = "full_name")
	    private String name;

	    // column name is "email_address", cannot be null
	    @Column(name = "email_address", nullable = false)
	    private String email;

	    // column must be unique (for example, phone number or Aadhaar)
	    @Column(unique = true)
	    private String identifier;
	    
	    @Column(unique = true)
	    private String mobile;
	    
	    @OneToOne(cascade = CascadeType.ALL)   // One person has one passport
	    @JoinColumn(name = "passport_id")      // foreign key in person table
	    private Passport passport;

	    public Person() {}

	    public Person(String name, String email, String mobile) {
	        this.name = name;
	        this.email = email;
	        this.mobile = mobile;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getIdentifier() {
			return identifier;
		}

		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public Passport getPassport() {
			return passport;
		}

		public void setPassport(Passport passport) {
			this.passport = passport;
		}
	    





}
