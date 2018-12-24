/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType.Classes;

/**
 *
 * @author kumar
 */
public class Classes {
    private int id;
    private String name;
    private int tutionFee;
    private int computer;
    
        public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
        
        public int getTutionFee() {
		return tutionFee;
	}

	public void setTutionFee(int tutionFee) {
		this.tutionFee = tutionFee;
	}

	public int getComputer() {
		return computer;
	}

	public void setComputer(int computer) {
		this.computer = computer;
	}
    
}
