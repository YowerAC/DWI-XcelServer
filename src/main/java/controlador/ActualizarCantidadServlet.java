package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Producto;

@WebServlet("/ActualizarCantidadServlet")
public class ActualizarCantidadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idActualizar = Integer.parseInt(request.getParameter("id"));
        int nuevaCantidad = Integer.parseInt(request.getParameter("cantidad"));

        HttpSession session = request.getSession();
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito != null) {
            for (Producto producto : carrito) {
                if (producto.getId() == idActualizar) {
                    producto.setCantidad(nuevaCantidad);
                    break;
                }
            }
        }

        session.setAttribute("carrito", carrito);
        response.sendRedirect("carrito.jsp");
    }
}
