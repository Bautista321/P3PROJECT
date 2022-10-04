package p3project;
import java.util.*;
public class P3PROJECT 
{
    public static Scanner input = new Scanner(System.in).useDelimiter("\n");
    public static boolean stat = true;
    public static String choose;
    public static String name, gender, address, agestatus, status, department, cod, tod;
    public static int id, tid, age;
    private static final List<Patients> patientslist = new ArrayList<>();
   
    private static void NewPatient(Patients patients)
    {
        patientslist.add(patients);
    }
    
    public static void main(String[] args) 
    {
        mainfunct();
    }
    
    private static void mainfunct()
    {
        System.out.println("\n=====================");
        System.out.println("\nHospital Management System - Home Menu");
        System.out.println("\n=====================");
        System.out.println("[1] Add New Patients");
        System.out.println("[2] Show All Patient");
        System.out.println("[3] Search Patient");
        System.out.println("[4] Edit Patient Information");
        System.out.println("[5] Remove Patient");
        System.out.println("Select from 1-4");
        System.out.println("=====================");
        stat = true;
        while (stat)
        {
            System.out.print("\nEnter Selection: ");
            choose = input.next();
            switch (choose) 
            {
                case "1":
                    AddNewPatients();
                    stat = false;
                    break;
                case "2":
                    ShowAllPatient();
                    stat = false;
                    break;
                case "3":
                    SearchPatient();
                    stat = false;
                    break;
                case "4":
                    EditPatientInfo();
                    stat = false;
                    break;
                case "5":
                    RemovePatient();
                    stat = false;
                    break;
                default:
                    System.out.println("Invalid Selection");
                    stat = true;
                    break;
            }
        }
    }
    private static void AddNewPatients()
    {
        System.out.println("\n=====================");
        System.out.println("\nHospital Management System - Add Patient");
        //stat = true;
        //while(stat)
        //{
            //System.out.print("\nEnter Patient ID: ");
            //String sid = input.next();
            //try 
            //{
                //id = Integer.parseInt(sid);
                //stat = false;
            //} catch(NumberFormatException e)
                //{
                    //System.out.println("Numbers Only");
                //}
        //}
        Random r = new Random();
        Set<Integer> uniqueID = new HashSet<>();
        while (uniqueID.size()<1)
        {
            uniqueID.add(r.nextInt(1000));
        }
        for (Integer tid : uniqueID)
        {
            id = tid;
        }
        System.out.print("Enter Patient Name: ");
        name = input.next();
        System.out.println("Select Gender");
        System.out.println("[1] Male");
        System.out.println("[2] Female");
        stat = true;
        while(stat)
        {
        System.out.print("Enter Selection: ");
        String sgchoose = input.next();
        try
        {
            int gchoose = Integer.parseInt(sgchoose);
            if(gchoose == 1)
            {
                gender = "Male";
                stat = false;
            } else if(gchoose == 2)
            {
                gender = "Female";
                stat = false;
            } else
            {
                System.out.println("Invalid Selection");
            }
        } catch(NumberFormatException e)
            {
                System.out.println("Numbers Only");
            }
        }
        
        System.out.print("Enter Patient Address: ");
        address = input.next();
        stat = true;
        while(stat)
        {
            System.out.print("Enter Patient Age: ");
            String sage = input.next();
            try 
            {
                age = Integer.parseInt(sage);
                if(age >= 0 && age <= 15)
                {
                    agestatus = "Child";
                } else if(age >= 16 && age <= 17)
                {
                    agestatus = "Teen";
                } else if(age >= 18 && age <= 59)
                {
                    agestatus = "Adult";
                } else if(age >= 60 && age <= 100)
                {
                    agestatus = "Senior";
                }
                stat = false;
            } catch(NumberFormatException e)
                {
                    System.out.println("Numbers Only");
                }
        }
        System.out.println("Select Patient Status");
        System.out.println("[1] Normal");
        System.out.println("[2] Critical");
        System.out.println("[3] Dead");
        stat = true;
        while(stat)
        {
        System.out.print("Enter Selection: ");
        String sschoose = input.next();
        try
        {
            int schoose = Integer.parseInt(sschoose);
            if(schoose == 1)
            {
                status = "Normal";
                stat = false;
            } else if(schoose == 2)
            {
                status = "Critical";
                stat = false;
            } else if(schoose == 3)
            {
                        
                System.out.print("Enter Patient Cause Of Death: ");
                cod = input.next();
                System.out.print("Enter Patient Time Of Death: ");
                tod = input.next();
                status = "Dead";
                stat = false;
            } else
            {
                System.out.println("Invalid Selection");
            }
        } catch(NumberFormatException e)
            {
                System.out.println("Numbers Only");
            }
        }
        System.out.println("Select Patient Department");
        System.out.println("[1] ER");
        System.out.println("[2] OR");
        System.out.println("[3] ICU");
        stat = true;
        while(stat)
        {
        System.out.print("Enter Selection: ");
        String sdchoose = input.next();
        try
        {
            int dchoose = Integer.parseInt(sdchoose);
            if(dchoose == 1)
            {
                department = "ER";
                stat = false;
            } else if(dchoose == 2)
            {
                department = "OR";
                stat = false;
            } else if(dchoose == 3)
            {
                department = "ICU";
                stat = false;
            } else
            {
                System.out.println("Invalid Selection");
            }
        } catch(NumberFormatException e)
            {
                System.out.println("Numbers Only");
            }
        }
        Patients patients = new Patients(id, name, gender, address, age, agestatus, status ,department, cod,  tod);
        NewPatient(patients);
        System.out.println("\nSuccessfully Added");
        mainfunct();
    }
    
    private static void ShowAllPatient()
    {
        System.out.println("\n=====================");
        System.out.println("\nHospital Management System - List of Patients");
        for(Patients patients: patientslist)
        {   
            System.out.println("\n=====================");
            System.out.println("\nPatient ID: " + patients.getid());
            System.out.println("Patient Name: " + patients.getname());
            System.out.println("Patient Gender: " + patients.getgender());
            System.out.println("Patient Address: " + patients.getaddress());
            System.out.println("Patient Age: " + patients.getage());
            System.out.println("Patient Age Status: " + patients.getagestatus());
            System.out.println("Patient Status: " + patients.getstatus());
            System.out.println("Patient Department: " + patients.getdepartment());
            if(patients.getstatus().equals("Dead"))
            {
                System.out.println("Patient Cause of Death: " + patients.getcod());
                System.out.println("Patient Time of Death: " + patients.gettod());
            }
        }
        mainfunct();
    }
    
    private static void SearchPatient()
    {
        System.out.println("\n=====================");
        System.out.println("Hospital Management System - Search Patient");
        stat = true;
        while(stat)
        {
            System.out.println("\n=====================");
            System.out.print("\nEnter Patient ID: ");
            String sid = input.next();
            try
            {
                id = Integer.parseInt(sid);
                for(Patients patients: patientslist)
                {
                    if(patients.getid() == id)
                    {
                        System.out.println("\n=====================");
                        System.out.println("\nPatient Found");
                        System.out.println("\nPatient ID: " + patients.getid());
                        System.out.println("Patient Name: " + patients.getname());
                        System.out.println("Patient Gender: " + patients.getgender());
                        System.out.println("Patient Address: " + patients.getaddress());
                        System.out.println("Patient Age: " + patients.getage());
                        System.out.println("Patient Age Status: " + patients.getagestatus());
                        System.out.println("Patient Status: " + patients.getstatus());
                        System.out.println("Patient Department: " + patients.getdepartment());
                        if(patients.getstatus().equals("Dead"))
                        {
                            System.out.println("Patient Cause of Death: " + patients.getcod());
                            System.out.println("Patient Time of Death: " + patients.gettod());
                        }
                        stat = false;
                        mainfunct();
                    }
                }
            } catch(NumberFormatException e)
            {
                System.out.println("\nNumbers Only");
            }
                System.out.println("\n=====================");
                System.out.println("\nPatient not found");
                stat = true;
        }
    }
    
    private static void EditPatientInfo()
    {
        System.out.println("\n=====================");
        System.out.println("\nHospital Management System - Edit Patient Info");
        stat = true;
        while(stat)
        {
            System.out.println("\n=====================");
            System.out.print("\nEnter Patient ID: ");
            String sid = input.next();
            try 
            {
                id = Integer.parseInt(sid);
                for(Patients patients: patientslist)
                {
                    if(patients.getid() == id)
                    {
                        System.out.println("\n=====================");
                        System.out.println("\nPatient ID: " + patients.getid());
                        System.out.println("Patient Name: " + patients.getname());
                        System.out.println("Patient Gender: " + patients.getgender());
                        System.out.println("Patient Address: " + patients.getaddress());
                        System.out.println("Patient Age: " + patients.getage());
                        System.out.println("Patient Age Status: " + patients.getagestatus());
                        System.out.println("Patient Status: " + patients.getstatus());
                        System.out.println("Patient Department: " + patients.getdepartment());
                        if(patients.getstatus().equals("Dead"))
                        {
                            System.out.println("Patient Cause of Death: " + patients.getcod());
                            System.out.println("Patient Time of Death: " + patients.gettod());
                        }
                        System.out.println("\n=====================");
                        System.out.println("\nChange Information");
                        System.out.println("[1] Patient Age");
                        System.out.println("[2] Patient Status");
                        System.out.println("[3] Patient Department"); 
                        System.out.println("[4] Patient Address");
                        stat = true;
                        while(stat)
                        {
                            System.out.println("\n=====================");
                            System.out.print("\nEnter Selection: ");
                            String sichoose = input.next();
                        try
                        {
                            int cichoose = Integer.parseInt(sichoose);
                            if(cichoose == 1)
                            {
                                stat = true;
                                while(stat)
                                {
                                    System.out.println("\n=====================");
                                    System.out.print("\nEnter New Patient Age: ");
                                    String cnage = input.next();
                                try
                                {
                                    age = Integer.parseInt(cnage);
                                    if(age >= 0 && age <= 15)
                                        {
                                            agestatus = "Child";
                                        } else if(age >= 16 && age <= 17)
                                        {
                                            agestatus = "Teen";
                                        } else if(age >= 18 && age <= 59)
                                        {
                                            agestatus = "Adult";
                                        } else if(age >= 60 && age <= 100)
                                        {
                                        agestatus = "Senior";
                                        }
                                    patients.setage(age);
                                    patients.setagestatus(agestatus);
                                    stat = false;
                                    mainfunct();
                                } catch(NumberFormatException e)
                                    {
                                        System.out.println("Numbers Only");
                                    }
                                }
                            } else if(cichoose == 2)
                            {
                                stat = true;
                                while(stat)
                                {
                                    System.out.println("\n=====================");
                                    System.out.println("\nNew Patient Status");
                                    System.out.println("[1] Normal");
                                    System.out.println("[2] Critical");
                                    System.out.println("[3] Dead");
                                    System.out.println("\n=====================");
                                    System.out.print("\nEnter Selection: ");
                                    String snstatus = input.next();
                                try
                                {
                                    int nstatus = Integer.parseInt(snstatus);
                                    if(nstatus == 1)
                                    {
                                        status = "Normal";
                                        patients.setstatus(status);
                                        stat = false;
                                        mainfunct();
                                    } else if(nstatus == 2)
                                    {
                                        status = "Critical";
                                        patients.setstatus(status);
                                        stat = false;
                                        mainfunct();
                                    } else if(nstatus == 3)
                                    {
                                        status = "Dead";
                                        patients.setstatus(status);
                                        stat = false;
                                        mainfunct();
                                    }    
                                } catch(NumberFormatException e)
                                {
                                    System.out.println("Numbers Only");
                                }    
                            }
                        } else if(cichoose == 3)
                        {
                            stat = true;
                            while(stat)
                            {
                                System.out.println("\n=====================");
                                System.out.println("\nNew Patient Department");
                                System.out.println("[1] ER");
                                System.out.println("[2] OR");
                                System.out.println("[3] ICU");
                                System.out.println("\n=====================");
                                System.out.print("\nEnter Selection: ");
                                String sndept = input.next();    
                                try
                                {
                                    int ndept = Integer.parseInt(sndept);
                                    if(ndept == 1)
                                    {
                                        department = "ER";
                                        patients.setdepartment(department);
                                        stat = false;
                                        mainfunct();
                                    } else if(ndept == 2)
                                    {
                                        department = "OR";
                                        patients.setdepartment(department);
                                        stat = false;
                                        mainfunct();
                                    } else if(ndept == 3)
                                    {
                                        department = "ICU";
                                        patients.setdepartment(department);
                                        stat = false;
                                        mainfunct();
                                    }
                                } catch(NumberFormatException e)
                                {
                                    System.out.println("Numbers Only");
                                }
                            }
                        } else if(cichoose == 4)
                        {
                            System.out.println("\n=====================");
                            System.out.print("\nEnter New Patient Address: ");
                            String naddress = input.next();
                            patients.setaddress(naddress);
                            stat = false;
                            mainfunct();
                        } else
                        {
                            System.out.println("Invalid Selection");
                        }
                    } catch(NumberFormatException e)
                    {
                        System.out.println("Numbers Only");
                    }
                }
            }
        }
    } catch(NumberFormatException e)
        {
            System.out.println("Numbers Only");
        }
                System.out.println("\n=====================");
                System.out.println("\nPatient not found");
                stat = true;
        }
    }
    private static void RemovePatient()
    {
        Set<Integer> uniqueID = new HashSet<>();
        System.out.println("\n=====================");
        System.out.println("Hospital Management System - Remove Patient");
        stat = true;
        while(stat)
        {
            System.out.println("\n=====================");
            System.out.print("\nEnter Patient ID: ");
            String rid = input.next();
            try
            {
                id = Integer.parseInt(rid);
                for(Patients patients: patientslist)
                {
                    if(patients.getid() == id)
                    {
                        System.out.println("\n=====================");
                        System.out.println("\nSuccessfully Removed");
                        patientslist.remove(patients);
                        uniqueID.remove(id);
                        stat = false;
                        mainfunct();
                    }
                }
            } catch(NumberFormatException e)
            {
                System.out.println("\nNumbers Only");
            }
                System.out.println("\n=====================");
                System.out.println("\nPatient not found");
                stat = true;
        }
    }
}
