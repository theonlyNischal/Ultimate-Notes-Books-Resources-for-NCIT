;.dosseg
.model small
.stack
.data
    message db '      sum is: $'
.code
    main proc
        .startup
        
        mov ah,01h
        int 21h 
        sub al,30h
        
        mov bl,al
        
        int 21h
        sub al,30h
        add al,bl
        
        
        push ax
        mov ah,09h
        lea dx,message
        int 21h   
        pop ax
        
        
        push ax
        cmp al,10
        
        jl skip
            mov dl, '1'
            mov ah,02h
            int 21h
        skip:
        
        pop ax
        
        aam        
        add al,30h
        mov dl,al
        mov ah,02h
        int 21h
        mov ah,4ch
        int 21h
        
        main endp
    end main
        
        