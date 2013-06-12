using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Entrega_Diseno
{
    interface CategoriaPersona
    {
        double PrecioDescuento { get; set; }

        float aplicarDescuento(float entradaBase);
        
    }
}
