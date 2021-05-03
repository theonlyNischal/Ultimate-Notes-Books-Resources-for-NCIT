;.dosseg
.model small
.stack
.data
    password db 'ncit$'
    successMessage db 10,13'Welcome!$'
    errorMessage db 10,13,'Invalid User$'
    enterMessage db 'Insert Password: $'
    input db ?

.code
    main proc
        .startup
        
        xor dx,dx
        xor ax,ax
        
        lea dx,enterMessage
        mov ah,09h
        int 21h
        lea di,input
        
        again:
            mov ah,01h
            int 21h
            
            cmp al, 13
            je checkPassword
            
            mov [di],al
            inc di
            jmp again
        
        checkPassword:
            
        
        lea si,password
        lea di,input 
        checkagain: 
            mov al,[si]
            mov bl,[di]
            
            cmp al,'$'
            je success
            
            cmp bl, 10
            je success
            
            cmp al,bl
            jne invalid
            
            inc si
            inc di
            jmp checkagain          
                    
        success:
        lea dx,successMessage
        mov ah,09h
        int 21h
        .exit
     
        invalid:
        lea dx,errorMessage
        mov ah,09h
        int 21h
        .exit

        main endp
    end main