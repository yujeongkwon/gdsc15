var aText = new Array(
    "모두가 숨죽인 듯 추적추적 빗소리 밖에 들리지 않는 어느 날 밤...",
    "어디선가 자꾸만 벨소리가 들려온다...",
    "공중전화 부스에서 전화벨이 계속 울린다...",
    "자꾸만 신경이 쓰인다. 한 번 받아볼까?",
    "받아보자... 당신은 선택권이 없다..."
    );

var iSpeed = 100; // time delay of print out
var iIndex = 0; // start printing array at this posision
var iArrLength = aText[0].length; // the length of the text array
var iScrollAt = 20; // start scrolling up at this many lines
     
var iTextPos = 0; // initialise text position
var sContents = ''; // initialise contents variable
var iRow; // initialise current row


const phoneCall = new Audio("/assets/phonecall.mp3");
phoneCall.src = "/assets/phonecall.mp3";

const rainySound = new Audio("/assets/rain.mp3");
rainySound.src = "/assets/rain.mp3";

const recieveKing = new Audio("/assets/recieveTheKing.mp3");
recieveKing.src = "/assets/recieveTheKing.mp3";

function typewriter() {
    phoneCall.play();
    rainySound.play();

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
typewriter();

function audioStop() {
    phoneCall.src = "/assets/phonecall.mp3";
    phoneCall.pause();
    recieveKing.play();
}

// var aText = new Array()
// typewriter(popup);

const [username, submitBtn] = document.querySelectorAll('input');
username.addEventListener('click',(event) => {
    audioStop();
})
submitBtn.addEventListener('click', (event) => {
    localStorage.setItem('user',username.value);
    location.href="/home";
});