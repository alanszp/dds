using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Entrega_Diseno
{
    class Mayor : CategoriaPersona
    {
        private float _PrecioDescuento;
        public float PrecioDescuento
        {
            get { return _PrecioDescuento; }
            set { _PrecioDescuento = 0; }
        }

        float CategoriaPersona.aplicarDescuento(float entradaBase)
        {
            return (entradaBase - PrecioDescuento);
        }


        double CategoriaPersona.PrecioDescuento
        {
            get
            {
                throw new NotImplementedException();
            }
            set
            {
                throw new NotImplementedException();
            }
        }
    }
}
