package com.mystic.layer7;

public class PasswordEncryptor
{
    String encodedString;
    public String encode(String s)
    {
        encodedString = "";
        int l = s.length();
        //reverse the string and increment every alt char by some k, add random salt at every odd index
        for (int i = 0; i < l; i++)
        {
            encodedString = (char)(s.charAt(l - i - 1) + 10) + "" + (int) (Math.random() * 9) + encodedString;
        }
        return encodedString;
    }

    public boolean comparePasswords(String p1, String p2)
    {
        int l1 = p1.length();
        int l2 = p2.length();
        if(l1 == l2)
        {
            for (int i = 0; i < l1; i += 2)
            {
                if(p1.charAt(i) != p2.charAt(i))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
