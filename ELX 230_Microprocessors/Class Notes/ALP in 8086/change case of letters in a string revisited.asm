.model small
.stack 100h
.data
    string db "THis is Test$"
    len db 13
.code
    main proc
        .startup
        
        lea si,string
        mov ch,00h
        mov cl,len
        repeat:
        cmp [si],'$'
        je done
        cmp [si], ' '
        je space
        cmp [si], 'a'
        jge small
        cmp [si], 'Z'
        jle big
        entry:
        mov dl,[si]
        mov ah,02h
        int 21h 
        inc si
        loop repeat    
        done:
        .exit        
        
        
        
        space: jmp entry
        small: sub [si],20h
                jmp entry
        big:  add [si],20h
        jmp entry
        
        main endp
    end main
    
           