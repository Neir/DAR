package org.apache.jsp.WEB_002dINF.pages.compte_005futilisateur.mot_005fde_005fpasse_005foublie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class confirmation_005fmdpo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"fr\">\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../import.jsp", out, false);
      out.write("\n");
      out.write("    \t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">\n");
      out.write("    \t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">\n");
      out.write("\t\t<meta name=\"generator\" content=\"Bootply\" />\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" media=\"screen\"/>\n");
      out.write("\t\t<!-- Faire fonctionner les balises structurantes de HTML5 -->\n");
      out.write("    \t<!--[if lt IE 9]>\n");
      out.write("      \t\t<script src=\"http://html5shiv.googlecode.com/svn/trunk/html5.js\"></script>\n");
      out.write("    \t<![endif]-->\n");
      out.write("\t\t<title>Réinitialiser mot de passe</title>\n");
      out.write("\t\t\n");
      out.write("\t\t<style type=\"text/css\">\n");
      out.write("      \t\tbody\n");
      out.write("\t\t\t{\n");
      out.write("\t\t\t    background-repeat:no-repeat;\n");
      out.write("\t\t\t    background-size:cover;\n");
      out.write("\t\t\t    width: 400px;\n");
      out.write("    \t\t\tmargin: auto;\n");
      out.write("    \t\t\tmargin-top : 20%;\n");
      out.write("\t\t\t    font-family: 'PT Sans', Helvetica, Arial, sans-serif;\n");
      out.write("\t\t\t    font-size: 16px;\n");
      out.write("\t\t\t}\n");
      out.write("    \t</style>\n");
      out.write("\t</head>\n");
      out.write("\t<body style=\"background-image:url(");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write(")\">\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../header.jsp" + (("../../header.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("page_active", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("confirmation_mdpo", request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("connected", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${connected}", java.lang.String.class, (PageContext)_jspx_page_context, null, false), request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("\t\n");
      out.write("\t\t<div class=\"container\" id=\"message\">\n");
      out.write("\t      <h4><span style=\"color:white;\">Le mot de passe vient d'être modifié avec succès</span></h4>\n");
      out.write("\t\n");
      out.write("\t      <div id=\"lien\">\n");
      out.write("\t\t<div><a href=\"hello\">retourner à la page d'Acceuil</a></div>\n");
      out.write("\t      </div>\n");
      out.write("\t    </div>\n");
      out.write("\t</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/pages/compte_utilisateur/mot_de_passe_oublie/confirmation_mdpo.jsp(11,31) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/resources/css/compte_utilisateur/mot_de_passe_oublie/confirmation_mdpo.css");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /WEB-INF/pages/compte_utilisateur/mot_de_passe_oublie/confirmation_mdpo.jsp(31,35) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/resources/images/paris.jpg");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }
}
