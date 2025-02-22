package com.jmarcostech.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jmarcostech.cursomc.domain.Categoria;
import com.jmarcostech.cursomc.domain.Cidade;
import com.jmarcostech.cursomc.domain.Cliente;
import com.jmarcostech.cursomc.domain.Endereco;
import com.jmarcostech.cursomc.domain.Estado;
import com.jmarcostech.cursomc.domain.ItemPedido;
import com.jmarcostech.cursomc.domain.Pagamento;
import com.jmarcostech.cursomc.domain.PagamentoComBoleto;
import com.jmarcostech.cursomc.domain.PagamentoComCartao;
import com.jmarcostech.cursomc.domain.Pedido;
import com.jmarcostech.cursomc.domain.Produto;
import com.jmarcostech.cursomc.domain.enums.TipoCliente;
import com.jmarcostech.cursomc.domain.enums.EstadoPagamento;
import com.jmarcostech.cursomc.repositories.CategoriaRepository;
import com.jmarcostech.cursomc.repositories.CidadeRepository;
import com.jmarcostech.cursomc.repositories.ClienteRepository;
import com.jmarcostech.cursomc.repositories.EnderecoRepository;
import com.jmarcostech.cursomc.repositories.EstadoRepository;
import com.jmarcostech.cursomc.repositories.ItemPedidoRepository;
import com.jmarcostech.cursomc.repositories.PagamentoRepository;
import com.jmarcostech.cursomc.repositories.PedidoRepository;
import com.jmarcostech.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository catrepo;
	@Autowired
	private ProdutoRepository prodrepo;
	@Autowired
	private EstadoRepository estadorepo;
	@Autowired
	private CidadeRepository cidaderepo;
	@Autowired
	private ClienteRepository clienterepo;
	@Autowired
	private EnderecoRepository enderecorepo;
	@Autowired
	private PedidoRepository pedidorepo;
	@Autowired
	private PagamentoRepository pagamentorepo;
	@Autowired
	private ItemPedidoRepository itempedidorepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//CATEGORIA COM PRODUTOS//
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		Categoria cat3 = new Categoria(null,"Cama mesa e banho");
		Categoria cat4 = new Categoria(null,"Eletronicos");
		Categoria cat5 = new Categoria(null,"Jardinagem");
		Categoria cat6 = new Categoria(null,"Decoracao");
		Categoria cat7 = new Categoria(null,"Perfumaria");

		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		Produto p4 = new Produto(null,"Mesa de escritório",300.00);
		Produto p5 = new Produto(null,"Toalha",50.00);
		Produto p6 = new Produto(null,"Colcha",200.00);
		Produto p7 = new Produto(null,"Tv true Color",1200.00);
		Produto p8 = new Produto(null,"Roçadeira",800.00);
		Produto p9 = new Produto(null,"Abajur",100.00);
		Produto p10 = new Produto(null,"Pendente",180.00);
		Produto p11 = new Produto(null,"Shampoo",90.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2,p4));
		cat3.getProdutos().addAll(Arrays.asList(p5,p6));
		cat4.getProdutos().addAll(Arrays.asList(p1,p2,p3,p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9,p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat1,cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		
		catrepo.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
		prodrepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11));
		
		//CIDADE COM ESTADOS//
		
		Estado est1= new Estado(null,"Minas gerais");
		Estado est2= new Estado(null,"São Paulo");
		
		Cidade cid1 = new Cidade(null,"Uberlândia", est1);
		Cidade cid2 = new Cidade(null,"São Paulo", est2);
		Cidade cid3 = new Cidade(null,"Campinas", est2);
		
		est1.getCidade().addAll(Arrays.asList(cid1));
		est2.getCidade().addAll(Arrays.asList(cid2,cid3));
		
		estadorepo.saveAll(Arrays.asList(est1,est2));
		cidaderepo.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		//CLIENTES COM ENDERECOS
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","36378912377",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("155466788","955884842"));
		
		Endereco e1 = new Endereco(null,"Rua Flores","300","Apto 303","Jardim","38859515",cli1,cid1);
		Endereco e2 = new Endereco(null,"Avenida Matos","105","Sala 800","Centro","99459445",cli1,cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienterepo.saveAll(Arrays.asList(cli1));
		enderecorepo.saveAll(Arrays.asList(e1,e2));
		
		//PEDIDOS E PAGAMENTOS
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"), cli1,e1);
		Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 19:35"), cli1,e2);
		
		Pagamento pagt1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagt1);
		
		Pagamento pagt2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagt2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidorepo.saveAll(Arrays.asList(ped1,ped2));
		pagamentorepo.saveAll(Arrays.asList(pagt1,pagt2));
		
		//PRODUTOS,ITENS DE PEDIDO E PEDIDO
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itempedidorepo.saveAll(Arrays.asList(ip1,ip2,ip3));
		
		
		
		
	}

}
