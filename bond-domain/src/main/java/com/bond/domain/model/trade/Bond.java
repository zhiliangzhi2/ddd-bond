package com.bond.domain.model.trade;

import com.bond.domain.exception.BizException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author anzj
 * @date 2022/12/18 20:00
 */
public class Bond {

    private String bondCode;

    private String bondName;

    private String issueStartDate;

    private String issueEndDate;


    public void checkIssueStatus(){
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date());

        if(Long.parseLong(today) < Long.parseLong(issueStartDate) || Long.parseLong(issueEndDate) < Long.parseLong(today)){
            throw new BizException("债权部不在发行期内");
        }
    }


    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public String getIssueStartDate() {
        return issueStartDate;
    }

    public void setIssueStartDate(String issueStartDate) {
        this.issueStartDate = issueStartDate;
    }

    public String getIssueEndDate() {
        return issueEndDate;
    }

    public void setIssueEndDate(String issueEndDate) {
        this.issueEndDate = issueEndDate;
    }
}
