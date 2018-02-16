function sidebar(id){

	document.getElementById(id).innerHTML=
    "<div class=\"sidebar\" data-color=\"white\">" + 

    	"<div class=\"sidebar-wrapper\">" + 
            "<div class=\"logo\" style=\"background-color: #109BF8;\">" + 
                "<a href=\"Dashboard.jsp\" class=\"simple-text\">" + 
                	"<img src=\"assets/img/circulo.png\" style=\"max-width: 50%\"><br>"+
                "</a>" + 
            "</div>"+

            "<ul class=\"nav\">"+
                "<li class=\"active\">"+
                    "<a href=\"ControllerMisPermisos\">"+
                        "<p>Mis Permisos</p>"+
                    "</a>"+
                "</li>"+
                "<li>"+
                    "<a href=\"ControllerNuevaSolicitud\">"+
                        "<p>Nuevo Permiso</p>"+
                    "</a>"+
                "</li>"+
                "<li>"+
                    "<a href=\"AprobarSolicitudes.jsp\">"+
                        "<p>Aprobar Solicitudes</p>"+
                    "</a>"+
                "</li>"+
                "<li>"+
                    "<a href=\"GenerarResoluciones.jsp\">"+
                        "<p>Generar Resoluciones</p>"+
                    "</a>"+
                "</li>"+
                "<li>"+
                    "<a href=\"VerificarDocumento.jsp\">"+
                        "<p>Verificador Documentos</p>"+
                    "</a>"+
                "</li>"+
            "</ul>"+
    	"</div>"+
    "</div>"+

    "<div class=\"main-panel\">"+
        "<div class=\"content\">"+
      	"</div>"+
    "</div>"
	;
}