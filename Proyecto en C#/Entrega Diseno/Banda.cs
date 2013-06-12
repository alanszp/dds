using System;
using System.Collections.Generic;
using System.Text;

namespace Entrega_Diseno
{
    class Banda
    {
        private string _Nombre;
        public string Nombre
        {
            get { return _Nombre; }
            set { _Nombre = value; }
        }
        private CategoriaBanda _Categoria;
        public CategoriaBanda Categoria
        {
            get { return _Categoria; }
            set { _Categoria = value; }
        }
    }
}
