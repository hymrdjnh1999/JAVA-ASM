package Models;

import Shareds.Person;

/**
 * Customer_ett
 */
public class Customer_ett extends Person implements Comparable<Customer_ett> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // private static final long serialVersionUID = 1L;
    Integer rewardPoint;

    public Customer_ett() {
    };

    public Customer_ett(String id) {
        this.setID("");
        this.setName("No name");
        this.setPhoneNumber("");
        this.rewardPoint = 0;
    };

    public int compareTo(Customer_ett customer) {
        if (rewardPoint == customer.getRewardPoint())
            return 0;
        else if (rewardPoint < customer.getRewardPoint())
            return 1;
        else
            return -1;
    }

    public void setRewardPoint(Integer point) {
        rewardPoint = point;
    }

    public Integer getRewardPoint() {
        return rewardPoint;
    }

}