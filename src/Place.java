public class Place { //Data Fields
//Data Fields
    /**
     * The zip code of the place
     */
    private String zip;
    /**
     * The name of the town
     */
    private String town;

    /**
     * The name of the state
     */
    private String state;
//Constructor

    /**
     * Constructs a place with
     *
     * @param zip   The zip code of the location @param town The name of the town
     * @param state The name of the state
     */
    public Place(String zip, String town, String state) {
        this.zip = zip;
        this.town = town;
        this.state = state;
    }
//Modifier methods

    /**
     * Sets the zipcode field.
     *
     * @param zip This is the zip code of the place.
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Sets the town field.
     *
     * @param town This is the town name.
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * Sets the state field.
     *
     * @param state This is the state name.
     */
    public void setState(String state) {
        this.state = state;
    }
//Accessor methods

    /**
     * Gets the zip code
     *
     * @return the zip as an String
     */
    public String getZip() {
        return zip;
    }

    /**
     * Gets the town name
     *
     * @return the town name
     */
    public String getTown() {
        return town;
    }

    /**
     * Gets the state name
     *
     * @return the state name
     */
    public String getState() {
        return state;
    }

    /**
     * Compares two zip codes for equality
     *
     * @param inputZip the input zip
     * @return outputs the boolean value if they are equal or not comparing the strings
     */
    public boolean equals(String inputZip) {
        return zip.equals(inputZip);
    }

    /**
     * "Prints all the information in a Place object" (book page 634)
     */
    public String toString() {
        return "Zip Code: " + zip + "\n" + "Town: " + town + "\n" +
                "State: " + state + "\n";
    }
}