package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Producto;

@WebServlet("/EliminarDelCarritoServlet")
public class EliminarDelCarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEliminar = Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito != null) {
            carrito.removeIf(producto -> producto.getId() == idEliminar);
        }

        session.setAttribute("carrito", carrito);
        response.sendRedirect("carrito.jsp");
    }
}
