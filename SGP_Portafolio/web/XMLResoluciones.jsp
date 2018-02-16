<%-- 
    Document   : XMLResoluciones
    Created on : 12-12-2017, 8:21:15
    Author     : Jonathan
--%>
<%@page import="Model.ResolucionesDetalle"%>
<%@page import="Model.Resoluciones"%>
<%@page import="java.util.List"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="com.sun.org.apache.xml.internal.serialize.OutputFormat"%>
<%@page import="com.sun.org.apache.xml.internal.serialize.XMLSerializer"%>
<%@page import="javax.xml.parsers.DocumentBuilderFactory;"%>
<%@page import="javax.xml.parsers.DocumentBuilder;"%>
<%@page import="javax.xml.transform.Transformer;"%>
<%@page import="javax.xml.transform.TransformerFactory;"%>
<%@page import="javax.xml.transform.dom.DOMSource;"%>
<%@page import="javax.xml.transform.stream.StreamResult;"%>
<%@page import="org.w3c.dom.Attr;"%>
<%@page import="org.w3c.dom.Document;"%>
<%@page import="org.w3c.dom.Element;"%>
<%@page import="java.io.File;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="table-responsive" id="div_print" >

                        <%
                            try {
                                DocumentBuilderFactory dbFactory
                                        = DocumentBuilderFactory.newInstance();
                                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                                Document doc = dBuilder.newDocument();

                                // root element
                                Element rootElement = doc.createElement("resoluciones");
                                doc.appendChild(rootElement);
                                List<Resoluciones> lst = (List<Resoluciones>) request.getAttribute("Resoluciones");
                                for (Resoluciones res : lst) {
                                    // carname element
                                    Element carnameRoot = doc.createElement("idDetallePermiso");
                                    carnameRoot.appendChild(doc.createTextNode(javax.xml.bind.DatatypeConverter.printHexBinary(res.getIdResolucion())));
                                    rootElement.appendChild(carnameRoot);

                                    Element carnameRoot2 = doc.createElement("nombreDescriptivo");
                                    carnameRoot2.appendChild(doc.createTextNode(res.getResolucion()));
                                    rootElement.appendChild(carnameRoot2);
                                    List<ResolucionesDetalle> lst2 = (List<ResolucionesDetalle>) request.getAttribute("ResolucionesDetalle");
                                    for (ResolucionesDetalle resDet : lst2) {
                                        // supercars element
                                        Element resolucionesDetalles = doc.createElement("resolucionesDetalles");
                                        rootElement.appendChild(resolucionesDetalles);

                                        // carname element
                                        Element carname6 = doc.createElement("idDetallePermiso");
                                        carname6.appendChild(doc.createTextNode(javax.xml.bind.DatatypeConverter.printHexBinary(resDet.getIdDetalleResolucion())));
                                        resolucionesDetalles.appendChild(carname6);

                                        // carname element
                                        Element carname2 = doc.createElement("nombreSolicitante");
                                        carname2.appendChild(doc.createTextNode(resDet.getPermisos().getUsuarios().getNombre()));
                                        resolucionesDetalles.appendChild(carname2);

                                        // carname element
                                        Element carname3 = doc.createElement("rutSolicitante");
                                        carname3.appendChild(doc.createTextNode(resDet.getPermisos().getUsuarios().getRut()));
                                        resolucionesDetalles.appendChild(carname3);

                                        // carname element
                                        Element carname = doc.createElement("fechaEmision");
                                        carname.appendChild(doc.createTextNode(resDet.getFechaemision().toString()));
                                        resolucionesDetalles.appendChild(carname);

                                        // carname element
                                        Element carname1 = doc.createElement("justificacion");
                                        carname1.appendChild(doc.createTextNode(resDet.getJustificacion()));
                                        resolucionesDetalles.appendChild(carname1);

                                        // carname element
                                        Element carname4 = doc.createElement("diasAfecto");
                                        carname4.appendChild(doc.createTextNode(resDet.getPermisos().getTiposPermisos().getDiasafectos().toString()));
                                        resolucionesDetalles.appendChild(carname4);

                                        // carname element
                                        Element carname5 = doc.createElement("recursoLegal");
                                        carname5.appendChild(doc.createTextNode(resDet.getRecursolegalafecto().toString()));
                                        resolucionesDetalles.appendChild(carname5);

                                    }

                                }
                                // write the content into xml file
                                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                                Transformer transformer = transformerFactory.newTransformer();
                                DOMSource source = new DOMSource(doc);
                                StreamResult result = new StreamResult(new File("C:\\Users\\Jonathan\\Desktop\\cars.xml"));
                                transformer.transform(source, result);

                                // Output to console for testing
                                OutputFormat format = new OutputFormat(doc);
                                format.setIndenting(true);
                                XMLSerializer serializer = new XMLSerializer(System.out, format);
                                serializer.serialize(doc);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        %>
                        <div class="table-responsive" id="div_print" > 
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body> 
</html>
