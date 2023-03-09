package model;

public class JavaBeans { 
		private String codigo;
		private String data;
		private String observacao;
		private String usuario;
		private String tipoUsuario;
		public JavaBeans() {
			super();
			
		}
		public JavaBeans(String codigo, String data, String observacao, String usuario, String tipoUsuario) {
			super();
			this.codigo = codigo;
			this.data = data;
			this.observacao = observacao;
			this.usuario = usuario;
			this.tipoUsuario = tipoUsuario;
		}
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public String getObservacao() {
			return observacao;
		}
		public void setObservacao(String observacao) {
			this.observacao = observacao;
		}
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public String getTipoUsuario() {
			return tipoUsuario;
		}
		public void setTipoUsuario(String tipoUsuario) {
			this.tipoUsuario = tipoUsuario;
		}	
					
		}


