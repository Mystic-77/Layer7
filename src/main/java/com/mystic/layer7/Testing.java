package com.mystic.layer7;

public class Testing
{
    public static void main(String[] args)
    {
        String p1 = "MysticHunter";
        String p2 = "MysticHunter";

        PasswordEncryptor passwordEncryptor = new PasswordEncryptor();

        String hp1 = passwordEncryptor.encode(p1);
        System.out.println("p1 : " + hp1);
        String hp2 = passwordEncryptor.encode(p2);
        System.out.println("p2 : " + hp2);

        if(passwordEncryptor.comparePasswords("k0}8n3p1", "k2}5n5p1"))
        {
            System.out.println("works");
        }
        else
        {
            System.out.println("F's in the chat pls");
        }
    }
}
