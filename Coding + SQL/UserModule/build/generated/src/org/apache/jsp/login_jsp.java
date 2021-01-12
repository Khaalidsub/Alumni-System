package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("   <head>\n");
      out.write("      <meta charset=\"utf-8\">\n");
      out.write("      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("       <title>Alumni Login System</title>\n");
      out.write("\n");
      out.write("      <!-- Bootstrap core CSS -->\n");
      out.write("      <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("      <style>\n");
      out.write("         .bd-placeholder-img {\n");
      out.write("           font-size: 1.125rem;\n");
      out.write("           text-anchor: middle;\n");
      out.write("           -webkit-user-select: none;\n");
      out.write("           -moz-user-select: none;\n");
      out.write("           -ms-user-select: none;\n");
      out.write("           user-select: none;\n");
      out.write("         }\n");
      out.write("\n");
      out.write("         @media (min-width: 768px) {\n");
      out.write("           .bd-placeholder-img-lg {\n");
      out.write("             font-size: 3.5rem;\n");
      out.write("           }\n");
      out.write("         }\n");
      out.write("      </style>\n");
      out.write("\n");
      out.write("      <!-- Custom styles for this template -->\n");
      out.write("      <link href=\"css/navbar-top-fixed.css\" rel=\"stylesheet\">\n");
      out.write("      \n");
      out.write("     <!-- JQUERY -->\n");
      out.write("      <script\n");
      out.write("         src=\"https://code.jquery.com/jquery-3.4.1.min.js\"\n");
      out.write("        integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\"\n");
      out.write("         crossorigin=\"anonymous\"></script>\n");
      out.write("        <script type=\"text/javascript\"\n");
      out.write("                src=\"https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js\">\n");
      out.write("                    \n");
      out.write("        </script>\n");
      out.write("      \n");
      out.write("   </head>\n");
      out.write("\n");
      out.write("   <body>\n");
      out.write("\n");
      out.write("      \n");
      out.write("\n");
      out.write("      <main role=\"main\" class=\"container\">\n");
      out.write("\n");
      out.write("       \n");
      out.write("\n");
      out.write("         <div class=\"row\">\n");
      out.write("             <div class=\"col\"></div>\n");
      out.write("                 \n");
      out.write("            <div class=\"col-6\">\n");
      out.write("                \n");
      out.write("               <div class=\"card shadow\">\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                     <h2>Login</h2>\n");
      out.write("                     <br>\n");
      out.write("                     <form action=\"SignInController\" method=\"post\">\n");
      out.write("                     <div class=\"form-floating sm-3\">\n");
      out.write("                         <label for=\"floatingInput\">Email address</label>\n");
      out.write("                         <input type=\"email\" class=\"form-control\" id=\"floatingInput\" placeholder=\"name@example.com\" name=\"Email\" required>           \n");
      out.write("                    </div>\n");
      out.write("                     \n");
      out.write("                    <div class=\"form-floating\">\n");
      out.write("                        <label for=\"floatingPassword\">Password</label>\n");
      out.write("                      <input type=\"password\" class=\"form-control\" id=\"floatingPassword\" placeholder=\"Password\" name=\"password\" required>  \n");
      out.write("                    </div>    \n");
      out.write("                         <br>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                         <br>\n");
      out.write("                         <button type=\"submit\" class=\"btn btn-primary\">Login</button> Dont have an account yet? \n");
      out.write("                           <a href=\"register.html\"><button type=\"button\" class=\"btn btn-danger\" >Sign Up</button></a>\n");
      out.write("                     </form>\n");
      out.write("                  </div>\n");
      out.write("               </div>\n");
      out.write("               \n");
      out.write("            </div>\n");
      out.write("              <div class=\"col\"></div>\n");
      out.write("         </div>\n");
      out.write("\n");
      out.write("      </main>\n");
      out.write("\n");
      out.write("      <footer class=\"container\">\n");
      out.write("         <br />\n");
      out.write("        \n");
      out.write("      </footer>\n");
      out.write("      \n");
      out.write("      <script src=\"js/jquery-3.5.1.min.js\"></script>\n");
      out.write("      <script src=\"js/popper.min.js\"></script>      \n");
      out.write("      <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("   </body>   \n");
      out.write("   \n");
      out.write("   <script type=\"text/javascript\">\n");
      out.write(" \n");
      out.write("    $(document).ready(function() {\n");
      out.write("        $(\"#loginForm\").validate({\n");
      out.write("            rules: {\n");
      out.write("                email: {\n");
      out.write("                    required: true,\n");
      out.write("                    email: true\n");
      out.write("                },\n");
      out.write("         \n");
      out.write("                password: \"required\"\n");
      out.write("            },\n");
      out.write("             \n");
      out.write("            messages: {\n");
      out.write("                email: {\n");
      out.write("                    required: \"Please enter email\",\n");
      out.write("                    email: \"Please enter a valid email address\"\n");
      out.write("                },\n");
      out.write("                 \n");
      out.write("                password: \"Please enter password\"\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write(" \n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("   \n");
      out.write("   \n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
