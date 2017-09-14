package com.my.jsp;

import com.my.graph;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Servlet extends HttpServlet {

    private String responseTemplate1
            = "<html>\n"
            + "<body>\n"
            + "<h2>";
    private String responseTemplate3
            = "<html>\n"
            + "<body>\n"
            + "<h2>";

    private String responseTemplate2
            = "</h2>\n"
            + "<form method='post'><input name='data'><input name='data2'><input type='submit'><input name='reset' type='reset'></form></body>\n"
            + "</html>";

    public String GraphWay (HttpServletRequest request) throws IOException{
        try {
            graph g =new graph();
            ArrayList<Integer>adj[]=g.initadj2();
            boolean[] u=g.initused2();
            int a,b;
            if (request.getParameter("data")==null || request.getParameter("data2")==null){
                return "No data";
            }
            if (!g.check(request.getParameter("data")) || !g.check(request.getParameter("data2")))
            {
                String err="There are wrong symbols at textfields";
                return err;
            }
            a=Integer.valueOf(request.getParameter("data"));
            b=Integer.valueOf(request.getParameter("data2"));
            return g.dfs(a,b,adj,u);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response, request.getParameter("data"),request.getParameter("data2"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response, request.getParameter("data"),request.getParameter("data2"));
    }

    private void process(HttpServletRequest request, HttpServletResponse response, String data,String data2) throws IOException {
        response.setStatus(200);
        response.getWriter().write(responseTemplate1);

        if (data != null && data2 != null) {
            response.getWriter().write(GraphWay(request));
        } else {
            response.getWriter().write("data is not provided");
        }

        response.getWriter().write(responseTemplate2);;
        response.getWriter().write("shit");
    }
}
