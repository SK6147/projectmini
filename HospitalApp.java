
import java.util.*;

class Patient { // pojo class
  private String name, gender, city, address, dateofadmission, guardianname, guardianaddress;
  private int patientid, age;
  private long contactNum, aadharCardNum, guardiancontactNum;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDateofadmission() {
    return dateofadmission;
  }

  public void setDateofadmission(String dateofadmission) {
    this.dateofadmission = dateofadmission;
  }

  public String getGuardianname() {
    return guardianname;
  }

  public void setGuardianname(String guardianname) {
    this.guardianname = guardianname;
  }

  public String getGuardianaddress() {
    return guardianaddress;
  }

  public void setGuardianaddress(String guardianaddress) {
    this.guardianaddress = guardianaddress;
  }

  public int getPatientid() {
    return patientid;
  }

  public void setPatientid(int patientid) {
    this.patientid = patientid;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public long getContactNum() {
    return contactNum;
  }

  public void setContactNum(long contactNum) {
    this.contactNum = contactNum;
  }

  public long getAadharCardNum() {
    return aadharCardNum;
  }

  public void setAadharCardNum(long aadharCardNum) {
    this.aadharCardNum = aadharCardNum;
  }

  public long getGuardiancontactNum() {
    return guardiancontactNum;
  }

  public void setGuardiancontactNum(long guardiancontactNum) {
    this.guardiancontactNum = guardiancontactNum;
  }

}

class ArogyaHospital {
  ArrayList<Patient> al = new ArrayList<>();

  public void addPatient(int x, Scanner sc) {

    for (int i = 1; i <= x; i++) {
      Patient p = new Patient();
     
      System.out.println("Enter the patient Name");
      p.setName(sc.next());
      int age=0;
      do {
        System.out.println("Enter the Patient Age");
        age = sc.nextInt();
        if (age >= 1 && age <= 99) {
          p.setAge(age);
          break;
        } else {
          System.out.println("Entered age should be in between 1 - 99");
        }
      } while (true);
      System.out.println("Enter the gender");
      p.setGender(sc.next());

      String input;
      boolean valid = false;
      int count = 0;
      do {
        if (count == 0) {
          sc.nextLine();
        }
        System.out.println("Enter the Contact numbers");
        input = sc.nextLine();
        if (input.length() == 10
            && (input.charAt(0) == '6' || input.charAt(0) == '7' || input.charAt(0) == '8' || input.charAt(0) == '9')) {
          boolean allDigits = true;
          for (int j = 0; j < input.length(); j++) {
            if (!Character.isDigit(input.charAt(j))) {
              allDigits = false;
              break;
            }
          }
          if (allDigits) {
            valid = true;
          } else {
            count++;
            System.out.println("invalid input. please enter the valid 10 digits number");
          }
        } else {
          count++;
          System.out.println("please enter the 10 digits and contact number starting with 6, 7, 8, or 9.");
        }

      } while (!valid);
      p.setContactNum(Long.parseLong(input));
      System.out.println("Enter the City");
      p.setCity(sc.next());
      System.out.println("Enter the Address");
      p.setAddress(sc.next());
      sc.nextLine();
      System.out.println("Enter the Date of admission");
      p.setDateofadmission(sc.next());
      System.out.println("Enter the guardian's Name");
      p.setGuardianname(sc.next());
      System.out.println("Enter the guarian's adress");
      p.setGuardianaddress(sc.next());
      String input2;
      boolean valid2 = false;
      int count1 = 0;
      do {
        if (count1 == 0) {
          sc.nextLine();
        }
        System.out.println("Enter the gurdain's Contact numbers");
        input2 = sc.nextLine();
        if (input2.length() == 10 && (input2.charAt(0) == '6' || input2.charAt(0) == '7' || input2.charAt(0) == '8' || input2.charAt(0) == '9')) {
          boolean allDigits = true;
          for (int k = 0; k < input2.length(); k++) {
            if (!Character.isDigit(input2.charAt(k))) {
              allDigits = false;
              break;
            }
          }
          if (allDigits) {
            valid2 = true;
          } else {
            count1++;
            System.out.println("invalid input. please enter the valid 10 digits number");
          }
        } else {
          count1++;
          System.out.println("please enter the 10 digits and contact number starting with 6, 7, 8, or 9.");
        }

      } while (!valid);
      p.setGuardiancontactNum(Long.parseLong(input2));

      String input1;
      boolean valid1 = false;

      do {
        System.out.println("Enter the Patient Aadhar card number");
        input1 = sc.nextLine();
        if (input1.length() == 12) {
          boolean allDigits = true;
          for (int k = 0; k < input1.length(); k++) {
            if (!Character.isDigit(input1.charAt(k))) {
              allDigits = false;
              break;
            }
          }
          if (allDigits) {
            valid1 = true;
          } else {
            System.out.println("invalid input. Please Enter the 12 digits valid AadharCard number");
          }
        } else {
          System.out.println("please enter a valid 12 digits Aadhar number");
        }
      } while (!valid1);
      p.setAadharCardNum(Long.parseLong(input1));
      String id =null;
      id=id = String.valueOf(input1).substring(0, 4) + String.valueOf(input2).substring(0, 4) + age;

      al.add(p);
    }

    System.out.println("Sucessfully add patient details");
  }
   public void list(Patient patient){
    System.out.println("Patient name " + patient.getName());
        System.out.println("Patient Adhar Number : " + patient.getAadharCardNum());
        System.out.println("Patient Address : " + patient.getAddress());
        System.out.println("Patient CITY : " + patient.getCity());
        System.out.println("Patient CONTACT NUMBER : " + patient.getContactNum());
        System.out.println("Patient DATE OF ADMISSSION : " + patient.getDateofadmission());
        System.out.println("Patient Guardian's Name : " + patient.getGuardianname());
        System.out.println("Patient Guardian's Address : " + patient.getGuardianaddress());
        System.out.println("Patient Guardian's Contact : " + patient.getGuardiancontactNum());
    
  }

  public void searchbyId(Scanner sc) {
    System.out.println("Enter the id : ");
    int id = sc.nextInt();
    for (Patient patient : al) {
      if (id == patient.getPatientid()) {
       list(patient);
      }
    }

  }
  public void searchbyNAME(Scanner sc) {
    sc.nextLine();
    System.out.println("Enter the Name : ");
    String name = sc.nextLine();
    for (Patient patient : al) {
      if (name.equals(patient.getName())) {
       list(patient);
      }
    }

  }
  public void searchbyCity(Scanner sc){
    sc.nextLine();
    System.out.println("Enter the city");
    String city= sc.nextLine();
    for(Patient patient:al){
      if(city.equals(patient.getCity())){
       list(patient); 
      }
    }
    }
  
  public void searchbyAge(Scanner sc){
    System.out.println("Enter the minimum age : ");
    int min=sc.nextInt();
    System.out.println("Enter the maximum age : ");
    int max=sc.nextInt();
    for(Patient patient:al){
      if(patient.getAge()>=min && patient.getAge()<=max){
        list(patient);
      }
    }
  }

  public void displayAll() {
    System.out.println("Patient Names : ");
    for (Patient patient : al) {
      System.out.println(patient.getName());
    }

  }

  public void removePatient(Scanner sc) {
    System.out.println("enter the patient Id you want to remove :");
    int id = sc.nextInt();
    boolean found = false;// int count=0
    for (Patient iterable_patient : al) {
      if (id == iterable_patient.getPatientid()) {
        al.remove(iterable_patient);
        found = true;// count++;
        break;
      }
    }
    if (found==true) {// count=1;
      System.out.println("Id is successfully removed ");
    } else {
      System.out.println("Available to find id");
    }
  }

 

  public void ViewOptions(Scanner sc) {
    int option=0;
    do{
      System.out.println("*********************************************");
      System.out.println("Enter 1 : Add Patient details");
      System.out.println("Enter 2 : Searching by using PatientID");
      System.out.println("Enter 3 : Searching by using patientName");
      System.out.println("Enter 4 : Searching by using city");
      System.out.println("Enter 5 : Searching by using Age");
      System.out.println("Enter 6 : Remove patient details");
      System.out.println("Enter 7 : Dispaly all the patient Name");
      System.out.println("Enter 8 : Exit");
      System.out.println("**********************************************");
      System.out.println("Enter the Option");

       option = sc.nextInt();

      switch (option) {
        case 1:
          System.out.println("How many patient details you want enter");
          int y = sc.nextInt();
          addPatient(y, sc);
          break;
        case 2:
          searchbyId(sc);
          break;
        case 3:
          searchbyNAME(sc);
          break;
        case 4:
          searchbyCity(sc);
          break;
        case 5:
          searchbyAge(sc);
          break;
        case 6:
          removePatient(sc);
          break;
        case 7:
          displayAll();
          break;
        case 8:
          System.out.println("Thank you for using the arogya hospial App");

        default:
          break;
      }

    }while(option!=8);
      
  }
}

public class HospitalApp {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArogyaHospital a = new ArogyaHospital();
    a.ViewOptions(sc);
  }
}