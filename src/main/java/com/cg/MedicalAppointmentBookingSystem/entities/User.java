package com.cg.MedicalAppointmentBookingSystem.entities;
/***
 * User class is an abstract class that represents a user in the system.
 * It contains common attributes and methods for all users.
 * It contains the overall Boilerplate code for the other entity classes that extends from User.
 *
 * @author Subhojeet
 */

abstract public class User {
    protected String id;
    protected String name;

    public User(){}
    
    /***
	 * Constructor to create a user with ID and name.
	 * @param id The ID of the user.
	 * @param name The name of the user.
	 */
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    /**
     * 
     * @return the String of the user.
     */
    abstract String showProfile();
    
    /***
     * 
     * @return the ID of the user.
     */
    public String getId() {
        return id;
    }
    
    /***
     * 
     * @return the name of the user.
     */
    public String getName() {
        return name;
    }
}
