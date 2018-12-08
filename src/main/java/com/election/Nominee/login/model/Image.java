package com.election.Nominee.login.model;

public class Image
{
    private String isDefault;

    private String url;

    public String getIsDefault ()
    {
        return isDefault;
    }

    public void setIsDefault (String isDefault)
    {
        this.isDefault = isDefault;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [isDefault = "+isDefault+", url = "+url+"]";
    }
}
