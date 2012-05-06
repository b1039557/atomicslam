import placements.Student
import placements.PlacementOppurtunity
import placements.Status
import placements.Application 


class BootStrap {

    def init = { servletContext -> 

    def  studentumair = new Student(name:'umair',courseCode:'T500', notes:'talanted' ,applications:'five').save();

    def  applicationmoh = new Application(student:'muhammad', placement:'technical' ,status:'open' ,timestamp:'12/03/2011').save();   

    def  statuslol = new Status(code:'123jkbd343',description:'join programme').save();

     def Placeopp = new PlacementOppurtunity(jobTitle:'software engineer', companyName:'microsoft', applications:'five', status:'extended').save();    
   
   

    }
    def destroy = {
    }
}
