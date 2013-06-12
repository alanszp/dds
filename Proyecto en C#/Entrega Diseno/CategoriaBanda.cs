using System;
using System.Collections.Generic;
using System.Text;

namespace Entrega_Diseno
{
    class CategoriaBanda
    {
        private int _Tipo;
        public int Tipo
        {
            get { return _Tipo; }
            set { _Tipo = value; }
        }
        private int _PrecioExtra;
        public int PrecioExtra
        {
            get { return _PrecioExtra; }
            set { _PrecioExtra = value; }
        }
    }
}
