package p3.hospital.management.system;
public class Patients 
{
    private String pname, pgender, pagestatus, pstatus, pdepartment;
    private int pid, page;
    
    Patients(int id, String name, String gender, int age, String agestatus, String status, String department)
    {
        this.pid = id;
        this.pname = name;
        this.pgender = gender;
        this.page = age;
        this.pagestatus = agestatus;
        this.pstatus = status;
        this.pdepartment = department;
    }
    
    public int getid()
    {
        return pid;
    }
    
    public void setid(int id)
    {
        this.pid = id;
    }
    
    public String getname()
    {
        return pname;
    }
    
    public void setname(String name)
    {
        this.pname = name;
    }
        
    public String getgender()
    {
        return pgender;
    }
    
    public void setgender(String gender)
    {
        this.pgender = gender;
    }
    
    public int getage()
    {
        return page;
    }
    
    public void setage(int age)
    {
        this.page = age;
    }
    
    public String getagestatus()
    {
        return pagestatus;
    }
    
    public void setagestatus(String agestatus)
    {
        this.pagestatus = agestatus;
    }
    
    public String getstatus()
    {
        return pstatus;
    }
    
    public void setstatus(String status)
    {
        this.pstatus = status;
    }
    
    public String getdepartment()
    {
        return pdepartment;
    }
    
    public void setdepartment(String department)
    {
        this.pdepartment = department;
    }
}
