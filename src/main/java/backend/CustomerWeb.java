/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;


public class CustomerWeb extends UserWeb{

    
    private int id;

    public CustomerWeb(int id, String name, String phoneNumber, String address, String email) {
        super(name, phoneNumber, address, email);
        this.id = id;
    }

    public CustomerWeb(String name, String phoneNumber, String address, String email) {
        super(name, phoneNumber, address, email);
    }

   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
  
   
    
 
}


