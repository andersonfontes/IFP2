/**
 * Confirmação de exclusao de um contato
 @author Anderson
 */

function confirmar(codigo) {
	
	let resposta = confirm("Confirma a a exclusao deste contato?")
	if (resposta===true){
		window.location.href= "delete?codigo=" + codigo
		
		} else {
			close()			
		}
	}
	