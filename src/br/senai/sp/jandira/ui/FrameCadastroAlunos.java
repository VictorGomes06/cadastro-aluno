package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import br.senai.sp.jandira.model.Periodo;
import javax.swing.AbstractListModel;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField txtmatricula;
	private JTextField textField;

	public FrameCadastroAlunos() {
		setTitle("Cadastro de Alunos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblmatricula = new JLabel("Matr\u00EDcula");
		lblmatricula.setToolTipText("");
		lblmatricula.setBounds(10, 22, 61, 14);
		contentPane.add(lblmatricula);
		
		txtmatricula = new JTextField();
		txtmatricula.setBounds(81, 19, 86, 20);
		contentPane.add(txtmatricula);
		txtmatricula.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setToolTipText("");
		lblNome.setBounds(10, 50, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(81, 47, 116, 20);
		contentPane.add(textField);
		
		JLabel lblperiodo = new JLabel("Per\u00EDodo :");
		lblperiodo.setBounds(10, 87, 46, 14);
		contentPane.add(lblperiodo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Periodo.values()));
		comboBox.setToolTipText("");
		comboBox.setBounds(66, 83, 86, 22);
		contentPane.add(comboBox);
		
		JButton btnsalvar = new JButton("Salvar aluno");
		btnsalvar.setBounds(29, 141, 164, 23);
		contentPane.add(btnsalvar);
		
		JLabel lbllista = new JLabel("Lista de Alunos :");
		lbllista.setBounds(232, 22, 86, 14);
		contentPane.add(lbllista);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(232, 50, 144, 200);
		contentPane.add(scrollPane);
		
		JList listAlunos = new JList();
		listAlunos.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listAlunos.setBounds(232, 49, 144, 186);
		contentPane.add(listAlunos);
	}
}
