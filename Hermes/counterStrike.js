var bombPlanted = false;
var bombExplosed = false;
var pylonAmorced = '';
var terroristWin = false;
var counterTerroristWin = false;
var bombTimer = 120;
var ROUND_DURATION = 300;
 
function inputButton(idPylon, idButton)
{
	//Si la bombe n'est pas encore pos�e, appuyer sur le bouton la pose:
    if (bombPlanted == false)
  	{
		bombPlanted = true;
		pylonAmorced = idPylon;
	}
 
  	//Si la bombe est d�ja pos�e, appuyer sur le bouton la desamorce:
  	else
  	{
		//On v�rifie qu'on defuse le bon pylone (celui qui a la bombe):
		if (idPylon == pylonAmorced)
		{
			//Bombe d�samorc�e:
			counterTerroristWin = true;
    	}
  	}
}
 
function tick(nbTick)
{
	//Si la bombe a �t� pos�e:
	if (bombPlanted == true)
  	{
		//On diminue le timer de la bombe:
		bombTimer--;
   
    	//Si la bombe arrive a 0, elle explose, les Ts ont gagn�:
		if(bombTimer <= 0)
    	{
			bombExploded = true;
      		terroristWin = true;
    	}
  	}
 
	//Si on atteint la fin du temps reglementaire, les CTs ont gagn�:
	if(nbTick >= ROUND_DURATION)
  	{
		counterTerroristWin = true;
  	}
  	
  	var endGame = victory();
  	
  	return endGame;
}
 
function victory()
{
	if(terroristWin == true || counterTerroristWin == true)
  	{
		return true;
  	}
  	else
 	{
		return false;
  	}
}