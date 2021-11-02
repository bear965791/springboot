new Vue({
    el: "#app",
    data: {
        coach:{
            skill:'',
            experience:'',
            account:'',
            coachInfo:'',
            certification:'',
            coachImage:''
            
        }
    },
    methods: {

        selectedImg(evt){ //讀取圖片
            const file = evt.target.files.item(0) 
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.addEventListener('load',this.imageLoaded);
        },
        imageLoaded(evt){ //更新圖片路徑
            this.coach.coachImage = evt.target.result
        },

        selectedCertification(evt){
            const file = evt.target.files.item(0) 
            const reader = new FileReader();
            reader.addEventListener('load',this.imageLoad);
            reader.readAsDataURL(file);
        },
        imageLoad(evt){ //更新圖片路徑
            this.coach.certification = evt.target.result
        },

    
        memberApplyForCoach(){

            axios.post(`http://localhost:8080/memberApplyingForCoach`,{

                skill : this.coach.skill,
                experience:this.coach.experience,
                account:this.coach.account,
                coachInfo:this.coach.coachInfo,
                certification:this.coach.certification,
                coachImage:this.coach.coachImage



            }).then((res) =>{
                console.log(res);



            })
            this.coach.skill ="";
            this.coach.experience ="";
            this.coach.account ="";
            this.coach.coachInfo ="";
            this.coach.certification="";
            this.coach.coachImage="";


        }
        
    },
})