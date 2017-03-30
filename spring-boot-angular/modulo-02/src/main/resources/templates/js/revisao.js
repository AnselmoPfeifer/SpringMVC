function exibeNome() {
    /*
     Ao declarar variaveis com var, exemplo: var nome = "Eu"
     Deixamos a variavel acessivel somente dentro do scopo
     */
    var elNome = document.getElementById('txtNome');
    var strNome = elNome.value;
    var elDisplay = document.getElementById('display');
    elDisplay.innerHTML = strNome;
}

function novoContato() {
    var elListaContatos = document.getElementById('listaContatos');
    var inputContato = document.createElement('input');

    // Cria nova Label
    var labelContato = document.createElement('label');
    labelContato.innerText = "Contato";

    // Adiciona <br>
    var brContato = document.createElement('br');

    // Adiciona um novo campo btn
    var btnExcluir = document.createElement('input');
    btnExcluir.setAttribute('type', 'button');
    btnExcluir.setAttribute('value', '-');
    btnExcluir.onclick =  function excluir() {
        elListaContatos.removeChild(divContato)

    };

    // Adiciona nova div
    var divContato = document.createElement('div');
    divContato.appendChild(labelContato);
    divContato.appendChild(inputContato);
    divContato.appendChild(btnExcluir);
    divContato.appendChild(brContato);

    elListaContatos.appendChild(divContato);

}