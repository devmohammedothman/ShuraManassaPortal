package com.sbm.shura.entity;

import javax.persistence.*;



@Table(name="COMMITTEE")
@Entity
@NamedQueries(value={
		@NamedQuery(name="comm.findAll", query="select c from Committee c"),
		@NamedQuery(name="comm.findById", query="select c from Committee c where c.id = :committeeId"),

})
public class Committee implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(insertable = true, nullable = false, unique = true, updatable = false)
    @SequenceGenerator(name = "committ_ID_Generator", sequenceName = "com_seq")
    @GeneratedValue(generator = "committ_ID_Generator", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "Name_AR", insertable = true, length = 50, nullable = false, unique = false, updatable = true)
    private String nameAr;
    
    
    @Column(name = "NAME_EN", insertable = true, length = 45, nullable = false, unique = false, updatable = true)
    private String nameEn;
    
    
   
    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "COMMANAGERID")
    private User comManager;
    

    

    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return this.id;
    }
 
    public void setNameAr(java.lang.String nameAr) {
        this.nameAr = nameAr;
    }
    
  
    public java.lang.String getNameAr() {
        return this.nameAr;
    }
  
    public void setNameEn(java.lang.String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameEn() {
        return this.nameEn;
    }

	public User getComManager() {
		return comManager;
	}

	public void setComManager(User comManager) {
		this.comManager = comManager;
	}
    

    
}

