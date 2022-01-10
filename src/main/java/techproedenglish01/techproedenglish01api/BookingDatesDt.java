package techproedenglish01.techproedenglish01api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/*
 * When you create a POJO Class ,it should have;
 *1-private variables
 *2-getter(),setter() methods for all variables
 *3-Constructor with all parameters  after this eclips help me
 *4-Constructor with all parameters
 *5-toString()
 */
public class BookingDatesDt { //we change it we make same in left side

@SerializedName("checkin")
@Expose
private String checkin;
@SerializedName("checkout")
@Expose
private String checkout;

public String getCheckin() {
return checkin;
}

public void setCheckin(String checkin) {
this.checkin = checkin;
}

public String getCheckout() {
return checkout;
}

public void setCheckout(String checkout) {
this.checkout = checkout;
}

public BookingDatesDt(String checkin, String checkout) {
	this.checkin = checkin;// remove super
	this.checkout = checkout;
}	
public BookingDatesDt() {// second times we used source to create contructor but uncheck all
}

@Override
public String toString() {
	return "BookingDatesDt [checkin=" + checkin + ", checkout=" + checkout + "]";
}

}