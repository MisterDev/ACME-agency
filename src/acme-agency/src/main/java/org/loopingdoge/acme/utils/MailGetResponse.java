
package org.loopingdoge.acme.utils;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MailGetResponse {

    @SerializedName("mails")
    @Expose
    private List<Mail> mails = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MailGetResponse() {
    }

    /**
     * 
     * @param mails
     */
    public MailGetResponse(List<Mail> mails) {
        super();
        this.mails = mails;
    }

    public List<Mail> getMails() {
        return mails;
    }

    public void setMails(List<Mail> mails) {
        this.mails = mails;
    }

}
