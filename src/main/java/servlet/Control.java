package servlet;

import datamapper.DataMapper;
import datasource.DataSource1;
import Users.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Control", urlPatterns = { "/Control" })
public class Control extends HttpServlet //TEST TEST
{
    DataMapper dm;

    public Control()
    {
        dm = new DataMapper(new DataSource1().getDataSource());
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        
        switch(request.getParameter("origin"))
        {
            case "login":
                {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    User user = dm.validateUser(username, password);

                    request.getSession().setAttribute("user", user);

                    //request.getRequestDispatcher("user.jsp").forward(request, response);
                    response.sendRedirect("order.jsp");                

                }
                break;           
            case "create":
                {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                  

                    dm.createUser(new User(username, password));

                    response.sendRedirect("usercreated.jsp");

                }
                break;
                    
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}