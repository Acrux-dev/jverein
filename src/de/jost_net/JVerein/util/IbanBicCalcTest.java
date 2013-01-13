package de.jost_net.JVerein.util;

import junit.framework.TestCase;

public class IbanBicCalcTest extends TestCase
{
  public void test01()
  {
    try
    {
      assertEquals("DE89370400440532013000",
          IbanBicCalc.createIban("532013000", "37040044", "DE"));
      assertEquals("AT611904300234573201",
          IbanBicCalc.createIban("234573201", "19043", "AT"));
      assertEquals("CH9300762011623852957",
          IbanBicCalc.createIban("11623852957", "00762", "CH"));
    }
    catch (IBANException e)
    {
      e.printStackTrace();
    }
  }

  public void test02()
  {
    try
    {
      IbanBicCalc.createIban("532013000", "37040044", "AA");
      fail("H�tte IBANException: 'Ung�ltiges Land: AA' werfen m�ssen");
    }
    catch (IBANException e)
    {
      assertEquals("Ung�ltiges Land: AA", e.getMessage());
    }
  }

  public void test03()
  {
    try
    {
      IbanBicCalc.createIban("532013000", "3704004", "DE");
      fail("H�tte eine IBANException werfen sollen: Bankleitzahl hat falsche L�nge f�r Deutschland");
    }
    catch (IBANException e)
    {
      assertEquals("Bankleitzahl hat falsche L�nge f�r Deutschland",
          e.getMessage());
    }
  }

  public void test04()
  {
    try
    {
      IbanBicCalc.createIban("532013000", "370400444", "DE");
      fail("H�tte eine IBANException werfen sollen: Bankleitzahl hat falsche L�nge f�r Deutschland");
    }
    catch (IBANException e)
    {
      assertEquals("Bankleitzahl hat falsche L�nge f�r Deutschland",
          e.getMessage());
    }
  }

  public void test05()
  {
    try
    {
      IbanBicCalc.createIban("12345678901", "37040044", "DE");
      fail("H�tte eine IBANException werfen sollen: Kontonummer zu lang f�r Deutschland");
    }
    catch (IBANException e)
    {
      assertEquals("Kontonummer zu lang f�r Deutschland", e.getMessage());
    }
  }

  public void test11()
  {
    try
    {
      assertTrue(IbanBicCalc.isValidIBAN("DE89370400440532013000"));
      assertTrue(IbanBicCalc.isValidIBAN("AT611904300234573201"));
      assertTrue(IbanBicCalc.isValidIBAN("CH9300762011623852957"));
    }
    catch (IBANException e)
    {
      e.printStackTrace();
    }
  }

  public void test12()
  {
    try
    {
      IbanBicCalc.isValidIBAN("AA89370400440532013000");
      fail("H�tte IBANException: 'Ung�ltiges Land: AA' werfen m�ssen");
    }
    catch (IBANException e)
    {
      assertEquals("Ung�ltiges Land: AA", e.getMessage());
    }
  }

  public void test13()
  {
    try
    {
      IbanBicCalc.isValidIBAN("DE893704004405320130000");
      fail("H�tte IBANException: 'Ung�ltige IBAN. Vorgeschrieben sind 22 f�r Deutschland' werfen m�ssen");
    }
    catch (IBANException e)
    {
      assertEquals("Ung�ltige IBAN. Vorgeschrieben sind 22 f�r Deutschland",
          e.getMessage());
    }
  }

  public void test14()
  {
    try
    {
      IbanBicCalc.isValidIBAN("AT6119043002345732010");
      fail("H�tte IBANException: 'Ung�ltige IBAN. Vorgeschrieben sind 20 f�r �sterreich' werfen m�ssen");
    }
    catch (IBANException e)
    {
      assertEquals("Ung�ltige IBAN. Vorgeschrieben sind 20 f�r �sterreich",
          e.getMessage());
    }
  }

  public void test15()
  {
    try
    {
      IbanBicCalc.isValidIBAN("CH93007620116238529570");
      fail("H�tte IBANException: 'Ung�ltige IBAN. Vorgeschrieben sind 21 f�r Schweiz' werfen m�ssen");
    }
    catch (IBANException e)
    {
      assertEquals("Ung�ltige IBAN. Vorgeschrieben sind 21 f�r Schweiz",
          e.getMessage());
    }
  }

  public void test16()
  {
    try
    {
      IbanBicCalc.isValidIBAN(null);
      fail("H�tte IBANException: 'IBAN ist leer' werfen m�ssen");
    }
    catch (IBANException e)
    {
      assertEquals("IBAN ist leer", e.getMessage());
    }
  }

  public void test17()
  {
    try
    {
      IbanBicCalc.isValidIBAN("DE");
      fail("H�tte IBANException: 'Ung�ltige IBAN. Landeskennung und/oder Pr�fziffer fehlen' werfen m�ssen");
    }
    catch (IBANException e)
    {
      assertEquals("Ung�ltige IBAN. Landeskennung und/oder Pr�fziffer fehlen",
          e.getMessage());
    }
  }

}
