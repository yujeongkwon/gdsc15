const getTranslate = async (text) => {
    const url = "https://openapi.naver.com/v1/papago/n2mt";
    var options = {
        'method':'post',
        'headers': {
            'X-Naver-Client-Id': "4nUQH84VreaoQfxkFlgW",
            'X-Naver-Client-Secret': "KPEKR5EBBY"
            // 4nUQH84VreaoQfxkFlgW
            // KPEKR5EBBY
        },
        'form': {
            'source':'ko',
            'target':'en',
            'text': text
        }
    };

    try {
        var response = await fetch(url, options);
        console.log(`Success ${JSON.stringify(response)}`);
    } catch(e) {
        console.log(e);
    }
}
// getTranslate();

const p = document.querySelector('p');
const pText = p.innerText;
p.style.display="none";
const user = localStorage.getItem("user");

const audio = new Audio("/assets/rain.mp3");
audio.src = "/assets/rain.mp3";
audio.play();

var aText = new Array(
    `To. ${user}`,
    "Я уверен, что у тебя все хорошо, потому что я буду 00 в будущем, я все знаю!",
    "Я не знаю, как тяжело было это сказать! Я ждал, пока ты пройдешь этот общественный телефон! Знаете ли вы, что в 2070 году, в ожидании этого дня, дрожал от телефонных звонков с воздуха?",    
    "Вот насколько я люблю себя и тебя люблю. Так как это ты в будущем, я вырос настолько, что могу гордиться собой! Как бы ты ни был трудным и темным, не сдавайся и беги, потому что ты сам так хорошо справляешься!",    
    "Время уже истекло! Тогда, привет, доверяй мне и доверяй тебе~",
    "00 в 2070 году",
    ""
    );

var iSpeed = 50; // time delay of print out
var iIndex = 0; // start printing array at this posision
var iArrLength = aText[0].length; // the length of the text array
var iScrollAt = 20; // start scrolling up at this many lines
     
var iTextPos = 0; // initialise text position
var sContents = ''; // initialise contents variable
var iRow; // initialise current row

function typewriter() {

    sContents =  ' ';
    iRow = Math.max(0, iIndex-iScrollAt);
    var destination = document.getElementById("typedtext");
     
    while ( iRow < iIndex ) {
        sContents += aText[iRow++] + '<br />';
    }
    destination.innerHTML = sContents + aText[iIndex].substring(0, iTextPos) + "_";
    if ( iTextPos++ == iArrLength ) {
        iTextPos = 0;
        iIndex++;
        if ( iIndex != aText.length ) {
            iArrLength = aText[iIndex].length;
            setTimeout("typewriter()", 500);
        }
    } else {
        setTimeout("typewriter()", iSpeed);
    }
};

//3. Phone is Ringing
const publicPhone = document.querySelector(".publicphone");
publicPhone.addEventListener('click', (event) => {
    event.target.className = "publicphoneStop";
    typewriter();
})


//2. blur
setTimeout(()=> {
    publicPhone.style.display="block";
}, 3000);

//4. on Hangle
const typingtext = document.querySelector('#typedtext');
let mouseenterFlag = false;
typingtext.addEventListener('mouseenter', (event) => {
    console.log(aText.length-1);
    if(iRow === aText.length - 1) {
        typingtext.innerText = aText[0];
        typingtext.innerText += `
        넌 틀림없이 잘 지내고 있을 거야 난 미래의 00이니까 난 다 알아!

        이 말이 하고 싶어서 얼마나 힘들었는지 몰라! 네가 이 공중전화를 지나갈 때까지 기다렸어! 2070년에 이날을 기다리며 공중전화에서 바들바들 떨고 있었던 날 아니?
        
        그만큼 난 나 자신을 사랑하고 널 사랑해. 미래의 너 그니까 지금의 나는 내가 봐도 자랑스러울 만큼 성장했어! 네가 아무리 힘들고 앞이 깜깜하더라도 포기하지 말고 달려왔으면 해 너는 스스로 너무 잘하고 있으니까!
        
        벌써 시간이 다 됐네! 그럼 안녕 날 믿고 널 믿어~
        
        2070년의 00이가`;

        const titleK = document.querySelector('text');
        titleK.innerHTML = "미래에서 온 편지";

        mouseenterFlag = true;
    }
});

//1. title
var titleArray = new Array("Der Ruf aus der Zukunft", "La chiamata dal futuro", "โทรศัพท์จากอนาคต", "cuộc gọi từ tương lai");
var titleIndex = 0;
const titleChange = () => {
    const title = document.querySelector('text');
    title.classList = [];
    void title.offsetWidth; 
    setTimeout(()=>{title.classList.add("strokeEffect")},100);
    
    title.innerHTML = titleArray[titleIndex];
    titleIndex += 1;
    if(titleIndex === titleArray.length - 1) {
        titleIndex = 0;
    }
    if(!mouseenterFlag){
        setTimeout(titleChange, 5000);   
    } else {
        return;
    }
}
setTimeout(titleChange, 8000);

//5. Easter Egg
var spanInnerText = ""
typingtext.addEventListener('click', ()=>{
    document.querySelector("#root").style.display = "none";
    document.querySelector(".background").setAttribute("src","../assets/easterEgg.png");
    document.querySelector(".background").className = "easterEgg";

    const span = document.createElement('span');
    span.innerHTML = pText;
    span.className = "mainText";
    console.log(document.querySelector('body'));
    document.body.appendChild(span);

    audio.pause();
})
