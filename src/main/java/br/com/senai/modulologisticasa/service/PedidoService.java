package br.com.senai.modulologisticasa.service;

import br.com.senai.modulologisticasa.dto.Pedido;
import jakarta.validation.constraints.NotNull;

public interface PedidoService {
	
	public Pedido buscarPorId(
			@NotNull(message = "O id d pedido é obrigatorio")
			Integer idPedido);
	
}
