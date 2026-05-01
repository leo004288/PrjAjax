// 1. 전체 동의 체크박스 로직
const checkAll = document.getElementById('checkAll');
const singleChecks = document.querySelectorAll('.single-check');

checkAll.addEventListener('change', (e) => {
    singleChecks.forEach(check => {
        check.checked = e.target.checked;
    });
});

// 2. 개별 체크 해제 시 전체 동의 해제
singleChecks.forEach(check => {
    check.addEventListener('change', () => {
        const allChecked = Array.from(singleChecks).every(c => c.checked);
        checkAll.checked = allChecked;
    });
});

// 3. 폼 제출 시 유효성 검사 (예시)
document.getElementById('signupForm').addEventListener('submit', (e) => {
    const pw = document.getElementById('password').value;
    const pwConfirm = document.getElementById('passwordConfirm').value;

    if (pw !== pwConfirm) {
        alert("비밀번호가 일치하지 않습니다.");
        e.preventDefault();
        return;
    }

    if (pw.length < 10) {
        alert("비밀번호를 10자 이상 입력해주세요.");
        e.preventDefault();
        return;
    }

    alert("가입을 축하합니다!");
});
