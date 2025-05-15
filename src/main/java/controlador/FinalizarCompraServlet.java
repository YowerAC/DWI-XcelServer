package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Producto;

@WebServlet("/FinalizarCompraServlet")
public class FinalizarCompraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        // Aquí podrías guardar la compra en la BD si estás listo para eso

        // Vaciar el carrito
        carrito.clear();
        session.setAttribute("carrito", carrito);

        // Redirigir a una página de confirmación
        response.sendRedirect("confirmacion.jsp");
    }
}
